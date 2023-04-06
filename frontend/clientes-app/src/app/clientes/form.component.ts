import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente';
import { ClienteService } from './cliente.service';
import { ActivatedRoute, Router } from '@angular/router';
import swal from 'sweetalert2';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  public titulo: string = "Crear Cliente"
  public cliente: Cliente = new Cliente();
  
  constructor(private clienteService: ClienteService, private router: Router, private activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.cargarCliente();
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

  public create(): void {
    this.clienteService.create(this.cliente)
      .subscribe(cliente => {
        this.router.navigate(['/clientes'])
        swal('Cliente guardado', `Cliente ${cliente.nombre} ${cliente.apellido} creado con éxito!`, 'success')
      }
      
    )
  }

  public update(): void {
    this.clienteService.update(this.cliente)
      .subscribe(
        cliente => {
          this.router.navigate(['/clientes'])
          swal('Cliente modificado', `Cliente ${cliente.nombre} ${cliente.apellido} modificado con éxito!`, 'success')
        }
      )
  }

}
