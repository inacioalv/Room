import { Router, ActivatedRoute } from "@angular/router";

import { Room } from "../room.model";
import { Component, OnInit } from "@angular/core";
import { RoomService } from "../room.service";

@Component({
  selector: "app-room-delete",
  templateUrl: "./room-delete.component.html",
  styleUrls: ["./room-delete.component.css"],
})
export class RoomDeleteComponent implements OnInit {
  room: Room;

  constructor(
    private roomService: RoomService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.roomService.readById(id).subscribe((room) => {
      this.room = room;
    });
  }

  deleteroom(): void {
    this.roomService.delete(this.room.id).subscribe(() => {
      this.roomService.showMessage("Room excluido com sucesso!");
      this.router.navigate(["/"]);
    });
  }

  cancel(): void {
    this.router.navigate(["/"]);
  }
}
