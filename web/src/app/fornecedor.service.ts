import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FornecedorService {

  private baseUrl = 'http://localhost:8090/fornecedores';

  constructor(private http: HttpClient) { }

  getFornecedor(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl+'/findById'}/${id}`);
  }

  createFornecedor(fornecedor: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl+'/save'}`, fornecedor);
  }

  updateFornecedor(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl+'/update'}/${id}`, value);
  }

  deleteFornecedor(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl+'/delete'}/${id}`, { responseType: 'text' });
  }

  getFornecedoresList(): Observable<any> {
    return this.http.get(`${this.baseUrl+'/findAll'}`);
  }
}