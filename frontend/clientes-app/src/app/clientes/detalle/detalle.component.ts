import { Component, OnInit, Input } from '@angular/core';
import { Cliente } from '../cliente';
import { ClienteService } from '../cliente.service';
import swal from 'sweetalert2';
import { HttpEventType } from '@angular/common/http';
import { ModalService } from './modal.service';
import { AuthService } from 'src/app/usuarios/auth.service';

@Component({
  selector: 'app-detalle',
  templateUrl: './detalle.component.html',
  styleUrls: ['./detalle.component.css']
})
export class DetalleComponent implements OnInit {
  
  @Input() cliente: Cliente;

  titulo: string = "Detalle del cliente";

  fotoSeleccionada: File;

  progreso: number = 0;

  // inyectamos ActivatedRoute para subscribir cuando cambia el parametro id
  constructor(
    private clienteService: ClienteService, 
    public modalService: ModalService, 
    public authService: AuthService) { }

  ngOnInit(): void {

  }
  /*ngOnInit(): void {
    // =+ convierte a number
    this.activatedRoute.paramMap.subscribe(params => {
      let id: number =+ params.get('id');
      if (id) {
        this.clienteService.getCliente(id).subscribe(cliente => {
          this.cliente = cliente;
        });
      }
    });
  }*/

  seleccionarFoto(event: any) {
    this.fotoSeleccionada = event.target.files[0];
    this.progreso = 0;
    console.log(this.fotoSeleccionada);
    if (this.fotoSeleccionada.type.indexOf('image') < 0) {
      swal('Error al seleccionar imagen', 'El archivo debe ser de tipo imagen', 'error');
      this.fotoSeleccionada = null;

    }
  }

  subirFoto() {
    if (!this.fotoSeleccionada) {
      swal('Error de carga', 'Debe seleccionar una foto', 'error');
    } else {
      this.clienteService.subirFoto(this.fotoSeleccionada, this.cliente.id)
      .subscribe(event => {
        if (event.type === HttpEventType.UploadProgress) {
          this.progreso = Math.round((event.loaded/event.total)*100);
        } else if (event.type === HttpEventType.Response) {
          let response: any = event.body;
          this.cliente = response.cliente as Cliente;
          this.modalService.notificarUpload.emit(this.cliente);
          swal('La foto se ha subido completamente !', `La foto ${this.cliente.foto} se subió con éxito`, 'success');
          this.fotoSeleccionada = null;
        }
      });
    }
  }

  cerrarModal() {
    this.modalService.cerrarModal();
    this.fotoSeleccionada = null;
    this.progreso = 0;
  }

  /*subirFoto() {
    if (!this.fotoSeleccionada) {
      swal('Error de carga', 'Debe seleccionar una foto', 'error');
    } else {
      this.clienteService.subirFoto(this.fotoSeleccionada, this.cliente.id)
      .subscribe(cliente => {
        this.cliente = cliente;
        swal('La foto se ha subido completamente !', `La foto ${this.cliente.foto} se subió con éxito`, 'success');
      });
    }
  }*/

}
