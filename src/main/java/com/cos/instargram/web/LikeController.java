package com.cos.instargram.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.instargram.config.auth.LoginUserAnnotation;
import com.cos.instargram.config.auth.dto.LoginUser;
import com.cos.instargram.service.LikesService;

import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@Controller
public class LikeController {

	
		private final LikesService likesService;
		
		@PostMapping("/likes/{imageId}")
		public ResponseEntity<?>  like(@PathVariable int imageId, @LoginUserAnnotation LoginUser loginUser) {
			likesService.좋아요(imageId, loginUser.getId());
			return new ResponseEntity<String>("ok", HttpStatus.OK);
		}
		
		@DeleteMapping("/likes/{imageId}")
		public ResponseEntity<?> disLike(@PathVariable int imageId, @LoginUserAnnotation LoginUser loginUser) {
			likesService.싫어요(imageId, loginUser.getId());
			return new ResponseEntity<String>("ok", HttpStatus.OK);
		}
}
