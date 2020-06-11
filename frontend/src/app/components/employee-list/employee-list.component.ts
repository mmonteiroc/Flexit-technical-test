import {Component, OnInit} from '@angular/core';
import {environment} from '../../../environments/environment';
import * as moment from 'moment';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.scss']
})
export class EmployeeListComponent implements OnInit {

  employeeList: Array<any>;

  constructor() {
  }


  async getEmployees() {
    this.employeeList = await fetch(`${environment.API}/employees`).then(x => x.json());
    this.employeeList.sort((itemA: any, itemB: any): number =>{
      const dateA = itemA.lastEventDate;
      const dateB = itemB.lastEventDate;

      /*
      * Si alguna esta a null/undefined
      * Significa que este usuario no tiene ultima
      * fecha, con lo cual, el es uno de los siguientes
      * a crear el evento
      * */
      if (!dateA) { return -1; }
      else if (!dateB) { return 1; }

      return moment(dateA).diff(moment(dateB));
    });
  }


  ngOnInit(): void {
    this.getEmployees();
  }

}
