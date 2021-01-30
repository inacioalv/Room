package com.inacioalves.saladereuniao.saladereuniao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inacioalves.saladereuniao.saladereuniao.exception.ResourceMotFoundException;
import com.inacioalves.saladereuniao.saladereuniao.model.Room;
import com.inacioalves.saladereuniao.saladereuniao.repository.RoomRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class RoomController  {
	
	@Autowired
	private RoomRepository repository;

	
	@GetMapping("/rooms")
	public List<Room> findAll() {
		return repository.findAll();
	}

	

	@GetMapping("/rooms/{id}")
	public ResponseEntity<Room> obterLancamento( @PathVariable(value = "id") Long id ) throws ResourceMotFoundException{
	Room room =	repository.findById(id).orElseThrow( () -> new ResourceMotFoundException("Room not found::"+id) );
	return ResponseEntity.ok().body(room);
	}

	
	@PostMapping("/rooms")
	public Room createRoom(@Valid @RequestBody Room room) {
		return repository.save(room);
	}

	
	@PutMapping("/rooms/{id}")
	public ResponseEntity<Room> updateRoom(@PathVariable(value = "id") Long id, @Valid @RequestBody  Room roomDatails) throws ResourceMotFoundException{
		Room room =	repository.findById(id).orElseThrow( () -> new ResourceMotFoundException("Room not found for this id::"+id) );
				room.setName(roomDatails.getName());
				room.setDate(roomDatails.getDate());
				room.setStartHour(roomDatails.getStartHour());
				room.setEndHour(roomDatails.getEndHour());
		final Room updateRoom = repository.save(room);
		return ResponseEntity.ok(updateRoom);
	}

	

	@DeleteMapping("/rooms/{id}")
	public Map<String, Boolean> deleteRoom(@PathVariable(value = "id") Long id) throws ResourceMotFoundException {
		Room room =	repository.findById(id).orElseThrow( () -> new ResourceMotFoundException("Room not found for this id::"+id) );
		repository.delete(room);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;		
	}
	

	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}


	


	

}
