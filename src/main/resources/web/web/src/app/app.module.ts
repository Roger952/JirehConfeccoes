import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateFornecedorComponent } from './create-fornecedor/create-fornecedor.component';
import { FornecedorDetailsComponent } from './fornecedor-details/fornecedor-details.component';
import { FornecedorListComponent } from './fornecedor-list/fornecedor-list.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateFornecedorComponent,
    FornecedorDetailsComponent,
    FornecedorListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
