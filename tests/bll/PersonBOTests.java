package bll;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dal.PersonDAOStub;

class PersonBOTests {

	static PersonDAOStub daoStub;
	static PersonBO bo;
	@BeforeAll
	static void coldStart() {
		daoStub = new PersonDAOStub(); 
		bo = new PersonBO(daoStub);		
	}
	
	@BeforeEach
	void init(){
	}
	@Test
	@DisplayName("When Father and Mother are same")
	void testIsSibling() {
		Assertions.assertTrue(bo.isSibling(3, 4));
	}
	@Test
	@DisplayName("When Father and Mother are not same")
	void testIsSibling2() {
		Assertions.assertFalse(bo.isSibling(6, 7));
	}
	@Test
	@DisplayName("When Father is same and Mother is not same")
	void testIsSibling3() {
		Assertions.assertFalse(bo.isSibling(4, 5));
	}
	@Test
	@DisplayName("When Father is not same and Mother is same")
	void testIsSibling4() {
		Assertions.assertFalse(bo.isSibling(4, 6));
	}
	
	@Test
	@DisplayName("When Father and Mother are same")
	void testIsHalfSibling() {
		Assertions.assertFalse(bo.isHalfSibling(3, 4));
	}
	@Test
	@DisplayName("When Father and Mother are not same")
	void testIsHalfSibling2() {
		Assertions.assertFalse(bo.isHalfSibling(6, 7));
	}
	@Test
	@DisplayName("When Father is same and Mother is not same")
	void testIsHalfSibling3() {
		Assertions.assertTrue(bo.isHalfSibling(4, 5));
	}
	@Test
	@DisplayName("When Father is not same and Mother is same")
	void testIsHalfSiblings4() {
		Assertions.assertTrue(bo.isHalfSibling(4, 6));
	}
}
