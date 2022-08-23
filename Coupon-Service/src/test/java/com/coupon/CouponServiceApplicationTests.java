package com.coupon;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	public void saveTest() {
		Coupon coupon = new Coupon("2", "FOOD100", "Zomato", "food", "12% off", "2023-07-29", "199",
				"https://images.app.goo.gl/XNQ5gnCidxDjRGVb8");
		when(couponRepository.save(coupon)).thenReturn(coupon);
		assertEquals(coupon, couponService.addCoupon(coupon));
	}

	@Test
	public void findByIdTest() {
		when(couponRepository.findById("2")).thenReturn(Optional.of(new Coupon("2", "FOOD100", "Zomato", "food",
				"12% off", "2023-07-29", "199", "https://images.app.goo.gl/XNQ5gnCidxDjRGVb8")));
		Optional<Coupon> cou = couponService.getCouponById("2");
		assertEquals("2", cou.get().getCouponId());
		assertEquals("food", cou.get().getCategory());
		assertEquals("FOOD100", cou.get().getCouponCode());
		assertEquals("12%", cou.get().getOfferDetails());
		assertEquals("Zomato", cou.get().getProductName());
	}

	@Test
	public void findallTest() {
		Coupon c1 = new Coupon("1", "FOOD100", "Zomato", "food", "12% off", "2023-07-29", "199",
				"https://images.app.goo.gl/XNQ5gnCidxDjRGVb8");
		Coupon c2 = new Coupon("2", "FOOD100", "Zomato", "food", "12% off", "2023-07-29", "199",
				"https://images.app.goo.gl/XNQ5gnCidxDjRGVb8");
		Coupon c3 = new Coupon("3", "FOOD100", "Zomato", "food", "12% off", "2023-07-29", "199",
				"https://images.app.goo.gl/XNQ5gnCidxDjRGVb8");
		Coupon c4 = new Coupon("4", "FOOD100", "Zomato", "food", "12% off", "2023-07-29", "199",
				"https://images.app.goo.gl/XNQ5gnCidxDjRGVb8");
		List<Coupon> cou = new ArrayList<>();
		cou.add(c1);
		cou.add(c2);
		cou.add(c3);
		cou.add(c4);

		when(couponRepository.findAll()).thenReturn(cou);
		assertEquals(couponService.getAllCoupons().size(), 4);
	}

//	@Test
//	public void deleteByIdTest() {
//		when(couponRepository.findById("6")).thenReturn(Optional.of(new Coupon("6", "FOOD100", "Zomato", "food",
//				"12% off", "2023-07-29", "199", "https://images.app.goo.gl/XNQ5gnCidxDjRGVb8")));
//		doNothing().when(couponRepository).deleteById("6");
//		assertEquals(couponService.deleteCoupon("6"), "Id 6 deleted!");
//	}

}
