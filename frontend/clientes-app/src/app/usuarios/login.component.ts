import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  titulo: string = 'Por favor hacer inicio de sesión';

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  
}
