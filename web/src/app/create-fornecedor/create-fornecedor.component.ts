import { FornecedorService } from '../fornecedor.service';
import { Fornecedor } from '../fornecedor';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-fornecedor',
  templateUrl: './create-fornecedor.component.html',
  styleUrls: ['./create-fornecedor.component.css']
})
export class CreateFornecedorComponent implements OnInit {

  fornecedor: Fornecedor = new Fornecedor();
  submitted = false;

  constructor(private fornecedorService: FornecedorService,
    private router: Router) { }

  ngOnInit() {
  }

  newFornecedor(): void {
    this.submitted = false;
    this.fornecedor = new Fornecedor();
  }

  save() {
    this.fornecedorService.createFornecedor(this.fornecedor)
      .subscribe(data => console.log(data), error => console.log(error));
    this.fornecedor = new Fornecedor();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/save']);
  }
}