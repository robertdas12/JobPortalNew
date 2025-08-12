package com.Joboportal2.review.impl;


import com.Joboportal2.company.Company;
import com.Joboportal2.company.CompanyService;
import com.Joboportal2.review.Review;
import com.Joboportal2.review.ReviewRepository;
import com.Joboportal2.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

     private ReviewRepository reviewRepository;
     private CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(int companyId) {
         List<Review> reviews = this.reviewRepository.findByCompanyId(companyId);
        return  reviews;
    }

    @Override
    public String addReview(int companyId, Review review) {
         Company company =   this.companyService.getCompanyById(companyId);
         if (company!=null) {
             review.setCompany(company);
             this.reviewRepository.save(review);
             return  "review saved";
         }else{
              return  "company not found";
         }

    }

    @Override
    public Review getReviewById(int companyId, int reviewId) {
       List<Review> reviews =    this.reviewRepository.findByCompanyId(companyId);
       Review review1 = reviews.stream().filter(review->review.getId()==reviewId).findFirst().orElse(null);
        return review1;
    }

    @Override
    public Review updateReviews(int companyId, int reviewId, Review review) {
        List<Review> reviews =     this.reviewRepository.findByCompanyId(companyId);
       Review review1 = reviews.stream().filter(rw->rw.getId()==reviewId).findFirst().orElse(null);
        review1.setTitle(review.getTitle());
        review1.setDescription(review.getDescription());
        review1.setRating(review.getRating());
        review1.setCompany(review.getCompany());
        this.reviewRepository.save(review1);
        return  review1;
    }

    @Override
    public String deleteReview(int companyId, int reviewId) {
        if(this.companyService.getCompanyById(companyId)!=null && this.reviewRepository.existsById(reviewId)){
               Review review =    this.reviewRepository.findById(reviewId).orElse(null);
               Company company = review.getCompany();
               company.getReviews().remove(review);
               this.companyService.updateCompany(companyId,company);
               this.reviewRepository.deleteById(reviewId);
               return "review deleted successfully";
        }
        else {
            return  null;
        }
    }
}
