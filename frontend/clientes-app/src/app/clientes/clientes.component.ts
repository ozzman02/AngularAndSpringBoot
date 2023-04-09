import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente';
import { ClienteService } from './cliente.service';
import swal from 'sweetalert2';
import { tap } from 'rxjs';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit {
  
  clientes: Cliente[];

  constructor(private clienteService: ClienteService) {

  }

  /* 
      Aqui el tap ya viene con data transformada por el map.
      El subscribe podria ser vacio y la asignacion a clientes se podria hacer en el tap.

      tap(clientes => this.clientes = clientes).subscribe()
  */
  ngOnInit(): void {
    this.clienteService.getClientes().pipe(
      tap(clientes => {
        console.log('ClientesComponent: tap 3');
        clientes.forEach(cliente => {
          console.log(cliente.nombre);
        });
      })
    ).subscribe(
      clientes => this.clientes = clientes
    )
  }

  public delete(cliente: Cliente): void {
    swal({
      title: 'Confirmación de borrado',
      text: `¿Está seguro que desea eliminar al cliente ${cliente.nombre} ${cliente.apellido}?`,
      type: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Eliminar',
      cancelButtonText: 'Cancelar',
      confirmButtonClass: 'btn btn-success',
      cancelButtonClass: 'btn btn-danger',
      buttonsStyling: false,
      reverseButtons: true
    }).then((result) => {
      if (result.value) {
        this.clienteService.delete(cliente.id).subscribe(
          response => {
            this.clientes = this.clientes.filter(c => c !== cliente);
            swal('Cliente eliminado', `Cliente ${cliente.nombre} ${cliente.apellido} eliminado con éxito!`, 'success');
          }
        )
      } 
    })
  }

  
}
