import { Room } from '../room.model';

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RoomService } from '../room.service';

@Component({
  selector: 'app-create-room',
  templateUrl: './create-room.component.html',
  styleUrls: ['./create-room.component.css']
})
export class CreateRoom implements OnInit {

  room: Room = {
    name: '',
    date: '',
    startHour:'',
    endHour:''
  }

  constructor(private roomService:RoomService,
      private router: Router) { }

  ngOnInit(): void {
    
  }

  createroom(): void {
    this.roomService.create(this.room).subscribe(() => {
      this.roomService.showMessage('Room criado!')
      this.router.navigate(['/'])
    })

  }

  cancel(): void {
    this.router.navigate(['/'])
  }
}
