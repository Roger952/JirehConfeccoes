import { Fornecedor } from '../fornecedor';
import { Component, OnInit, Input } from '@angular/core';
import { FornecedorService } from '../fornecedor.service';
import { FornecedorListComponent } from '../fornecedor-list/fornecedor-list.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-fornecedor-details',
  templateUrl: './fornecedor-details.component.html',
  styleUrls: ['./fornecedor-details.component.css']
})
export class FornecedorDetailsComponent implements OnInit {

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

  list(){
    this.router.navigate(['/findById']);
  }
}