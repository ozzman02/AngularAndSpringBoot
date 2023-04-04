import { Component } from '@angular/core';
import { Cliente } from './cliente';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent {

  clientes: Cliente[] = [
    { id: 1, nombre: 'Oscar', apellido: 'Santamaria', email: 'osantmaria@gmail.com', createAt: '2023-04-04' },
    { id: 2, nombre: 'Luis', apellido: 'Venegas', email: 'lvenegas@gmail.com', createAt: '2023-04-04'},
    { id: 3, nombre: 'Karla', apellido: 'Solis', email: 'ksolis@gmail.com', createAt: '2023-04-04'},
    { id: 4, nombre: 'Melissa', apellido: 'Protti', email: 'mprotti@gmail.com', createAt: '2023-04-04'},
    { id: 5, nombre: 'Ronald', apellido: 'Palacios', email: 'rpalacios@gmail.com', createAt: '2023-04-04'}
  ];

}
