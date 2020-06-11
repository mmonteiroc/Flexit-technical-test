import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import * as moment from 'moment';
import {environment} from '../../../environments/environment';

@Component({
  selector: 'app-employee-generator',
  templateUrl: './employee-generator.component.html',
  styleUrls: ['./employee-generator.component.scss']
})
export class EmployeeGeneratorComponent implements OnInit {

  newEmployee = new FormGroup({
    name: new FormControl(),
    lastEventDate: new FormControl()
  });

  constructor() {
  }

  ngOnInit(): void {
  }

  async saveEmployee(): Promise<any> {

    const lastEventDate = moment(this.newEmployee.controls.lastEventDate.value).format('YYYY-MM-DD');
    const name = this.newEmployee.controls.name.value;

    const response = await fetch(environment.API + '/employee', {
      method: 'POST',
      body: JSON.stringify({
        name,
        lastEventDate
      })
    });

    console.log(response.status);
  }
}
