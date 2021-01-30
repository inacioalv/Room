import { Router } from '@angular/router';

import { Room } from '../room.model';
import { Component, OnInit } from '@angular/core';
import { RoomService } from '../room.service';

@Component({
  selector: 'app-room-list',
  templateUrl: './room-list.component.html',
  styleUrls: ['./room-list.component.css']
})
export class RoomListComponent implements OnInit {

  rooms: Room[]
  displayedColumns = ['id','name', 'date', 'startHour','endHour', 'action']
  
  constructor(private roomService: RoomService,
              private router:Router) { }

  ngOnInit(): void {
    this.roomService.read().subscribe(rooms => {
      this.rooms = rooms
    })
  }

  navigateToroomCreate(): void {
    this.router.navigate(['/rooms/create'])
  }

}
