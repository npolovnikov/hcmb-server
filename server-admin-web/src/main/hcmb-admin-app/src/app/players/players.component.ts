import { Component, OnInit } from '@angular/core';
import { RestServiceService } from "../rest-service/rest-service.service";
import { BaseComponent } from "../base-component/base.component";
import {PlayerModel} from "../model/player.model";

@Component({
  selector: 'app-players',
  templateUrl: './players.component.html',
  styleUrls: ['./players.component.scss']
})
export class PlayersComponent implements OnInit, BaseComponent {
  displayedColumns: string[] = ['name', 'country', 'ovr'];
  dataSource:PlayerModel[];

  length = 100;
  pageSize = 10;
  pageSizeOptions: number[] = [5, 10, 25, 100];

  constructor(private restServise: RestServiceService){
  }

  ngOnInit() {
    this.open();
  }

  open() {
    this.restServise.getPlayerList({}).subscribe(dataSource => {
      this.dataSource = dataSource;
      console.log("getPlayerList", dataSource);
    });
  }

}
