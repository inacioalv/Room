import { Room } from "../room.model";
import { Router, ActivatedRoute } from "@angular/router";

import { Component, OnInit } from "@angular/core";
import { RoomService } from "../room.service";

@Component({
  selector: "app-room-update",
  templateUrl: "./room-update.component.html",
  styleUrls: ["./room-update.component.css"],
})
export class RoomUpdateComponent implements OnInit {
  room: Room;

  constructor(
    private roomService: RoomService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get("id");
    this.roomService.readById(id).subscribe((room) => {
      this.room = room;
    });
  }

  updateroom(): void {
    this.roomService.update(this.room).subscribe(() => {
      this.roomService.showMessage("Room atualizado com sucesso!");
      this.router.navigate(["/"]);
    });
  }

  cancel(): void {
    this.router.navigate(["/"]);
  }
}
