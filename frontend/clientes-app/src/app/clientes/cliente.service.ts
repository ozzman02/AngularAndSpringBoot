import { Injectable } from '@angular/core';
import { catchError, map, of, throwError } from 'rxjs';
import { Observable } from 'rxjs';
import { Cliente } from './cliente';
//import { CLIENTES } from './clientes.json';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import swal from 'sweetalert2';
import { Router } from '@angular/router';
import { DatePipe } from '@angular/common';

@Injectable()
export class ClienteService {

  private urlEndpoint: string = 'http://localhost:8080/api/clientes';

  private httpHeaders = new HttpHeaders({
    'Content-Type': 'application/json'
  });

  constructor(private http: HttpClient, private router: Router) { }

  /*
      Implementacion inicial
        
        return of(CLIENTES);
        return this.http.get<Cliente[]>(this.urlEndpoint);

      Date pipes formatDate:
      
        cliente.createAt = formatDate(cliente.createAt, 'dd-MM-yyyy', 'en-US');

      Date pipes: registerLocaleData:
        
        registerLocaleData(localeES, 'es')
        let datePipe = new DatePipe('es');
        cliente.createAt = datePipe.transform(cliente.createAt, 'dd/MM/yyyy');
        cliente.createAt = datePipe.transform(cliente.createAt, 'fullDate');

      Habilitar LOCALE_ID para que funcione aun mas global en app.module. 
      Tambien iene efecto en los templates.

  */
  getClientes(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>(this.urlEndpoint).pipe(
      map(response => {
        let clientes = response as Cliente[];
        return clientes.map(cliente => {
          cliente.nombre = cliente.nombre.toUpperCase();
          //let datePipe = new DatePipe('es');
          //cliente.createAt = datePipe.transform(cliente.createAt, 'EEEE dd, MMMM yyyy');
          return cliente;
        })
      })
    );
  }

  getCliente(id: number): Observable<Cliente> {
    return this.http.get<Cliente>(`${this.urlEndpoint}/${id}`).pipe(
      catchError(e => {
        this.router.navigate(['/clientes']);
        console.error(e.error.mensaje);
        swal('Error al editar cliente', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  create(cliente: Cliente): Observable<any> {
    return this.http.post<any>(this.urlEndpoint, cliente, {headers: this.httpHeaders}).pipe(
      catchError(e => {
        console.error(e.error.mensaje);
        swal(e.error.mensaje, e.error.error, 'error');
        return throwError(e);
      })
    );
  }

  update(cliente: Cliente): Observable<any> {
    return this.http.put<any>(this.urlEndpoint, cliente, {headers: this.httpHeaders}).pipe(
      catchError(e => {
        if (e.status == 400) {
          return throwError(e);
        }
        console.error(e.error.mensaje);
        swal(e.error.mensaje, e.error.error, 'error');
        return throwError(e);
      })
    );
  }

  delete(id: number): Observable<Cliente> {
    return this.http.delete<Cliente>(`${this.urlEndpoint}/${id}`, {headers: this.httpHeaders}).pipe(
      catchError(e => {
        console.error(e.error.mensaje);
        swal(e.error.mensaje, e.error.error, 'error');
        return throwError(e);
      })
    );
  }

  /*create(cliente: Cliente): Observable<Cliente> {
    return this.http.post<Cliente>(this.urlEndpoint, cliente, {headers: this.httpHeaders}).pipe(
      catchError(e => {
        console.error(e.error.mensaje);
        swal(e.error.mensaje, e.error.error, 'error');
        return throwError(e);
      })
    );
  }*/

  /*create(cliente: Cliente): Observable<Cliente> {
    return this.http.post(this.urlEndpoint, cliente, {headers: this.httpHeaders}).pipe(
      map((response: any) => response.cliente as Cliente),
      catchError(e => {
        if (e.status == 400) {
          return throwError(e);
        }
        console.error(e.error.mensaje);
        swal(e.error.mensaje, e.error.error, 'error');
        return throwError(e);
      })
    );
  }*/

}
