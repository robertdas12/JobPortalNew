package com.Joboportal2.review;

import java.util.List;

public interface ReviewService {

     public List<Review> getAllReviews(int companyId);
     public  String addReview(int companyId,Review review);
     public  Review getReviewById(int companyId,int reviewId);
     public  Review updateReviews(int companyId,int reviewId,Review review);
     public  String deleteReview(int companyId, int reviewId);
}
