package com.Joboportal2.review;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private  ReviewService reviewService;




    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


       @GetMapping("/reviews")
      public ResponseEntity<List<Review>> getAllReviews(@PathVariable  int companyId){
          List<Review> reviews =  this.reviewService.getAllReviews(companyId);
          if(reviews!=null){
               return new ResponseEntity<>(reviews, HttpStatus.OK);
          }
          else {
               return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      @PostMapping("/addReview")
      public  ResponseEntity<String> addReviews(@PathVariable int companyId, @RequestBody Review review){
          String result = this.reviewService.addReview(companyId,review);
          if(result!=null){
              return  new ResponseEntity<>(result,HttpStatus.CREATED);
          }
          else {
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      @GetMapping("/review/{reviewId}")
      public  ResponseEntity<Review> getReviewById(@PathVariable int companyId,@PathVariable int reviewId){
          Review review = this.reviewService.getReviewById(companyId, reviewId);
          if(review!=null){
               return  new ResponseEntity<>(review,HttpStatus.OK);
          }else{
              return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      @PutMapping("/review/{reviewId}")
      public ResponseEntity<Review> updateReview(@PathVariable int companyId,@PathVariable int reviewId,@RequestBody Review review){
          Review review1 = this.reviewService.updateReviews(companyId,reviewId,review);
           if (review1!=null){
                 return  new ResponseEntity<>(review1,HttpStatus.OK);
           }
           else {
               return new ResponseEntity<>(HttpStatus.NOT_FOUND);
           }
      }

      @DeleteMapping("/delete/{reviewId}")
      public  ResponseEntity<String> deleteReview(@PathVariable int companyId,@PathVariable int reviewId){
           String status =  this.reviewService.deleteReview(companyId,reviewId);
           if(status!=null){
                return  new ResponseEntity<>(status,HttpStatus.OK);
           }
           else{
                return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
           }
      }
}