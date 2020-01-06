import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateFornecedorComponent } from './create-fornecedor/create-fornecedor.component';
import { FornecedorDetailsComponent } from './fornecedor-details/fornecedor-details.component';
import { FornecedorListComponent } from './fornecedor-list/fornecedor-list.component';
import { HttpClientModule } from '@angular/common/http';
import { UpdateFornecedorComponent } from './update-fornecedor/update-fornecedor.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateFornecedorComponent,
    FornecedorDetailsComponent,
    FornecedorListComponent,
    UpdateFornecedorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }