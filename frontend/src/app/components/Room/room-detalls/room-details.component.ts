import { Room } from '../room.model';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { RoomService } from '../room.service';

@Component({
  selector: 'app-room-details',
  templateUrl: './room-details.component.html',
  styleUrls: ['./room-details.component.css']
})
export class RoomDetailsComponent implements OnInit {

  room:Room;

  constructor(private roomService: RoomService,
              private router:Router,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get("id");
    this.roomService.readById(id).subscribe((room) => {
      this.room = room;
      console.log(room);
      
    });
  }

  cancel(): void {
    this.router.navigate(['/'])
  }

}
