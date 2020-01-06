import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FornecedorDetailsComponent } from './fornecedor-details.component';

describe('FornecedorDetailsComponent', () => {
  let component: FornecedorDetailsComponent;
  let fixture: ComponentFixture<FornecedorDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FornecedorDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FornecedorDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
