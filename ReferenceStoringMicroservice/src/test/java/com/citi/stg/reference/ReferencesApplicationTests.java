
package com.citi.stg.reference;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.citi.stg.reference.model.Asset;
import com.citi.stg.reference.model.Assets;
import com.citi.stg.reference.model.Firm;
import com.citi.stg.reference.model.Firms;
import com.citi.stg.reference.service.UnmarshallingService;

@ActiveProfiles("test")
@SpringBootTest
class ReferencesApplicationTests {

	File firm_test_file = new File("src/main/resources/store/test_firms.xml");
	File asset_test_file = new File("src/main/resources/store/test_assets.xml");
	private ArrayList<Firm> firms;
	private ArrayList<Asset> assets;

	@Test
	void UnmarshallingTest() {

		// setting expected object
		firms = new ArrayList<Firm>();
		firms.add(new Firm("SLI", "State Life Insurance"));
		firms.add(new Firm("JDC", "Johnson Data Company"));
		Firms firms_expected = new Firms(firms);

		// Using makeObject method to get the actual object generated
		Firms firms_actual = (Firms) UnmarshallingService.makeObject(firm_test_file, Firms.class);

		// setting expected object
		assets = new ArrayList<Asset>();
		assets.add(new Asset("EQ", "Equities"));
		assets.add(new Asset("FD", "Fixed Deposit"));
		Assets assets_expected = new Assets(assets);

		// Using makeObject method to get the actual object generated
		Assets assets_actual = (Assets) UnmarshallingService.makeObject(asset_test_file, Assets.class);

		assertEquals(firms_expected.getFirms().toString(), firms_actual.getFirms().toString());
		assertEquals(assets_expected.getAssets().toString(), assets_actual.getAssets().toString());
	}

}
