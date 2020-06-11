import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeGeneratorComponent } from './employee-generator.component';

describe('EmployeeGeneratorComponent', () => {
  let component: EmployeeGeneratorComponent;
  let fixture: ComponentFixture<EmployeeGeneratorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeGeneratorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeGeneratorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
