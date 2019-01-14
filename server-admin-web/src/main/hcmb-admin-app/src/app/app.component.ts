import { Component } from '@angular/core';
import {RestServiceService} from "./rest-service/rest-service.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  constructor(private restServise: RestServiceService){

  }
}
