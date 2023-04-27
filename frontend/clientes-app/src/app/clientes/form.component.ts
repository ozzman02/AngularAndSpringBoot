import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente';
import { ClienteService } from './cliente.service';
import { ActivatedRoute, Router } from '@angular/router';
import swal from 'sweetalert2';
import { Region } from './region';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  public titulo: string = "Crear Cliente";
  public cliente: Cliente = new Cliente();
  public errores: string[];
  public regiones: Region[];
  
  constructor(private clienteService: ClienteService, private router: Router, private activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.cargarCliente();
    this.cargarRegiones();
  }

  private cargarCliente(): void {
    this.activatedRoute.params.subscribe(params => {
      let id = params['id']
      if (id) {
        this.clienteService.getCliente(id).subscribe(
          cliente => this.cliente = cliente
        )
      }
    })
  }

  private cargarRegiones(): void {
    this.clienteService.getRegiones().subscribe(regiones => this.regiones = regiones);
  }
  
  public create(): void {
    this.clienteService.create(this.cliente)
      .subscribe(
        cliente => {
          console.log(cliente);
          this.router.navigate(['/clientes'])
          swal('Cliente guardado', `Cliente ${cliente.nombre} ${cliente.apellido} creado con éxito!`, 'success')
        },
        err => {
          this.errores = err.error.errors as string[];
          console.error('Código del error desde el backend: ' + err.status);
          console.error(err.error.errors);
        }
    );
  }

  public update(): void {
    this.clienteService.update(this.cliente)
      .subscribe(
        cliente => {
          this.router.navigate(['/clientes'])
          swal('Cliente modificado', `Cliente ${cliente.nombre} ${cliente.apellido} modificado con éxito!`, 'success')
        },
        err => {
          this.errores = err.error.errors as string[];
          console.error('Código del error desde el backend: ' + err.status);
          console.error(err.error.errors);
        }
      )
  }

  compararRegion(o1: Region, o2: Region): boolean {
    if (o1 === undefined && o2 === undefined) {
      return true;
    }
    return o1 === null || o2 === null || o1 === undefined || o2 === undefined ? false : o1.id === o2.id;
  }

   /* El backend devuelve un map con mensajes */ 
  /*public create(): void {
    this.clienteService.create(this.cliente)
      .subscribe(json => {
        this.router.navigate(['/clientes'])
        swal('Cliente guardado', `${json.mensaje}: ${json.cliente.nombre}`, 'success')
      }
    )
  }*/

}
