import { FornecedorDetailsComponent } from '../fornecedor-details/fornecedor-details.component';
import { Observable } from "rxjs";
import { FornecedorService } from "../fornecedor.service";
import { Fornecedor } from "../fornecedor";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: "app-fornecedor-list",
  templateUrl: "./fornecedor-list.component.html",
  styleUrls: ["./fornecedor-list.component.css"]
})
export class FornecedorListComponent implements OnInit {
  fornecedores: Observable<Fornecedor[]>;

  constructor(private fornecedorService: FornecedorService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.fornecedores = this.fornecedorService.getFornecedoresList();
  }

  deleteFornecedor(id: number) {
    this.fornecedorService.deleteFornecedor(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  fornecedorDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updateFornecedor(id: number){
    this.router.navigate(['update', id]);
  }
}