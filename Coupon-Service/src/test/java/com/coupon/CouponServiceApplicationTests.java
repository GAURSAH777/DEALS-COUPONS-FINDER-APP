package com.coupon;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.coupon.model.Coupon;
import com.coupon.repository.CouponRepository;
import com.coupon.service.CouponService;

@SpringBootTest
class CouponServiceApplicationTests {

	@Autowired
	private CouponService couponService;

	@MockBean
	private CouponRepository couponRepository;

	@Test
	public void addCouponTest() {
		Coupon c = new Coupon();
		c.setCouponId("100");
		c.setCompanyName("Airtel");
		c.setCategory("Entertainment");
		c.setCouponCode("XYZ123#");
		c.setOfferDetails("60% off");
		c.setExpiryDate("2023-07-29");

		Mockito.when(couponRepository.save(c)).thenReturn(c);
		assertThat(couponService.addCoupon(c)).isEqualTo(c);
	}

	@Test
	public void getAllCouponsTest() {
		Coupon c = new Coupon();
		c.setCouponId("100");
		c.setCompanyName("Airtel");
		c.setCategory("Entertainment");
		c.setCouponCode("XYZ123#");
		c.setOfferDetails("60% off");
		c.setExpiryDate("2023-07-29");

		Coupon c1 = new Coupon();
		c1.setCouponId("101");
		c1.setCompanyName("Airtel");
		c1.setCategory("Entertainment");
		c1.setCouponCode("XYZ123@");
		c1.setOfferDetails("60% off");
		c1.setExpiryDate("2023-07-29");

		List<Coupon> coupons = new ArrayList<>();
		coupons.add(c1);
		coupons.add(c);

		Mockito.when(couponRepository.findAll()).thenReturn(coupons);
		assertThat(couponService.getAllCoupons()).isEqualTo(coupons);
	}

	@Test
	public void getCouponTest() {
		Coupon c = new Coupon();
		c.setCouponId("100");
		c.setCompanyName("Airtel");
		c.setCategory("Entertainment");
		c.setCouponCode("XYZ123#");
		c.setOfferDetails("60% off");
		c.setExpiryDate("2023-07-29");

		Mockito.when(couponRepository.findById("100").get()).thenReturn(c);
		assertThat(couponService.getCouponById("100")).isEqualTo(c);
	}

}
