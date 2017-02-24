package ua.entity;

import java.math.BigDecimal;
import java.util.Locale.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		//та сама одиниця з persistence.xml
		final EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("primary");
		//основний інтерфейс для роботи з БД
		final EntityManager em = factory.createEntityManager();
		//почати транзакцію
		em.getTransaction().begin();
		
		Country country = new Country();
		Country country1 = new Country();
		
		Size size = new Size();
		Size size1 = new Size();
		
		Power power = new Power();
		Power power1 = new Power();
		
		Kind kind = new Kind();
		Kind kind1 = new Kind();
		Kind kind2 = new Kind();
		Kind kind3 = new Kind();
		
		Brand brand = new Brand();
		Brand brand1 = new Brand();
		
		Item goods = new Item();
		Item goods1 = new Item();
		
		country.setName("GERMANY");
		em.persist(country);
		
		country1.setName("CHINA");
		em.persist(country1);
		
		size.setHeight(3);
		size.setLength(100);
		size.setWidth(45);
		em.persist(size);
		
		size1.setHeight(2);
		size1.setLength(150);
		size1.setWidth(60);
		em.persist(size1);
		;
		
		Power idPower = em.find(Power.class, 1);
		Power idPower2 = em.find(Power.class, 2);
		
		Size idSize = em.find(Size.class, 1);
		Size idSize2 = em.find(Size.class, 2);
		
	
		Country idCountry = em.find(Country.class, 1);
		Country idCountry2 = em.find(Country.class, 2);
		
		brand.setCountry(idCountry);
		brand.setName("SolarWorld");
		em.persist(brand);
		
		brand1.setCountry(idCountry2);
		brand1.setName("Perlight");
		em.persist(brand1);
		
		
		Brand idBrand = em.find(Brand.class, 1);
		Brand idBrand2 = em.find(Brand.class, 2);
		
		Kind idKind = em.find(Kind.class, 1);
		Kind idKind2 = em.find(Kind.class, 2);
		
		goods.setPrice(new BigDecimal(100.50));
		goods.setBrand(idBrand);
		goods.setKind(idKind);
		em.persist(goods);
		
		goods1.setPrice(new BigDecimal(150.50));
		goods1.setBrand(idBrand2);
		goods1.setKind(idKind2);
		em.persist(goods1);
		
		
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
