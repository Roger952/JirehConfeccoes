import { FornecedorDetailsComponent } from './fornecedor-details/fornecedor-details.component';
import { CreateFornecedorComponent } from './create-fornecedor/create-fornecedor.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FornecedorListComponent } from './fornecedor-list/fornecedor-list.component';
import { UpdateFornecedorComponent } from './update-fornecedor/update-fornecedor.component';

const routes: Routes = [
  { path: '', redirectTo: 'fornecedor', pathMatch: 'full' },
  { path: 'fornecedores', component: FornecedorListComponent },
  { path: 'add', component: CreateFornecedorComponent },
  { path: 'update/:id', component: UpdateFornecedorComponent },
  { path: 'details/:id', component: FornecedorDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }