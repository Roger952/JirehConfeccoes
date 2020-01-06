import { Component, OnInit } from '@angular/core';
import { Fornecedor } from '../fornecedor';
import { ActivatedRoute, Router } from '@angular/router';
import { FornecedorService } from '../fornecedor.service';

@Component({
  selector: 'app-update-fornecedor',
  templateUrl: './update-fornecedor.component.html',
  styleUrls: ['./update-fornecedor.component.css']
})
export class UpdateFornecedorComponent implements OnInit {

  id: number;
  fornecedor: Fornecedor;

  constructor(private route: ActivatedRoute,private router: Router,
    private fornecedorService: FornecedorService) { }

  ngOnInit() {
    this.fornecedor = new Fornecedor();

    this.id = this.route.snapshot.params['id'];
    
    this.fornecedorService.getFornecedor(this.id)
      .subscribe(data => {
        console.log(data)
        this.fornecedor = data;
      }, error => console.log(error));
  }

  updateFornecedor() {
    this.fornecedorService.updateFornecedor(this.id, this.fornecedor)
      .subscribe(data => console.log(data), error => console.log(error));
    this.fornecedor = new Fornecedor();
    this.gotoList();
  }

  onSubmit() {
    this.updateFornecedor();    
  }

  gotoList() {
    this.router.navigate(['/update']);
  }
}