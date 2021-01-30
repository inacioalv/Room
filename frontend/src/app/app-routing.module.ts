

import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";



import { CreateRoom } from './components/Room/create-room/create-room.component';
import { RoomDeleteComponent } from "./components/Room/room-delete/room-delete.component";
import { RoomDetailsComponent } from "./components/Room/room-details/room-details.component";
import { RoomListComponent } from './components/Room/room-list/room-list.component';
import { RoomUpdateComponent } from './components/Room/room-update/room-update.component';



const routes: Routes = [
  {
    path: "",
    component: RoomListComponent
  },
  
  {
    path: "rooms/create",
    component: CreateRoom
  },
  {
    path: "rooms/update/:id",
    component:RoomUpdateComponent
  },
  {
    path: "rooms/delete/:id",
    component: RoomDeleteComponent
  },
  {
    path:"rooms/details/:id",
    component:RoomDetailsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
