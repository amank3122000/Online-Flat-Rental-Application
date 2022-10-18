package com.cg.onlineflatrental.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.cg.onlineflatrental.entity.Tenant;
import com.cg.onlineflatrental.exception.TenantNotFoundException;
import com.cg.onlineflatrental.repository.ITenantRepository;

public class TenantServiceTest {
	@Mock
	private ITenantRepository tenantRepository;

	@InjectMocks
	private TenantService tenantService;

	@Test
	public void test_UpdateTenant() {

		Tenant c1 = new Tenant("Yathin", 22);
		assertThat(tenantRepository.findById(c1.getTenantId())).isNotEqualTo(c1);

	}

	@Test
	public void test_AddTenant() {
		Tenant c1 = new Tenant("Vamsi", 18);

		when(tenantRepository.save(c1)).thenReturn(c1);

		assertEquals(c1.getTenantId(), tenantService.addTenant(c1).getTenantId());

	}

	@Test
	public void test_viewAllTenant() throws Exception {
		Tenant cust1 = new Tenant(1, 18, null);
		Tenant cust2 = new Tenant(2, 19, null);

		List<Tenant> tenantlist = new ArrayList<Tenant>();
		tenantlist.add(cust1);
		tenantlist.add(cust2);
		Mockito.when(tenantRepository.findAll()).thenReturn(tenantlist);
		List<Tenant> result = (List<Tenant>) tenantService.viewAllTenant();
		assertEquals(2, result.size());

	}

	private void assertEquals(int i, int size) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void test_viewTenant_ThrowTenantNotFoundException() {
		try {
			Mockito.when(tenantService.viewTenant(1)).thenThrow(new TenantNotFoundException("not found"));
		} catch (Exception c1) {

			Assertions.assertThat(c1 instanceof TenantNotFoundException);
		}

	}
}

