package com.example.pruebatecnicacsti;

import com.example.pruebatecnicacsti.Model.Asset;
import com.example.pruebatecnicacsti.Repository.AssetRepository;
import com.example.pruebatecnicacsti.Service.AssetService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class AssetServiceTest {

    @Mock
    private AssetRepository assetRepository;

    @InjectMocks
    private AssetService assetService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterAsset() {
        Asset asset = new Asset();
        asset.setName("Computer");
        asset.setPurchaseValue(new BigDecimal("1000"));

        when(assetRepository.save(asset)).thenReturn(asset);

        Asset savedAsset = assetService.registerAsset(asset);

        assertNotNull(savedAsset);
        assertEquals(asset.getName(), savedAsset.getName());
        assertEquals(asset.getPurchaseValue(), savedAsset.getPurchaseValue());

        verify(assetRepository, times(1)).save(asset);
    }

    @Test
    public void testCalculateDepreciation() {
        Long assetId = 1L;
        Asset asset = new Asset();
        asset.setId(assetId);
        asset.setPurchaseValue(new BigDecimal("1000"));
        asset.setDepreciationRate(new BigDecimal("0.04"));

        when(assetRepository.findById(assetId)).thenReturn(Optional.of(asset));

        BigDecimal expectedCurrentValue = new BigDecimal("960.00");
        BigDecimal actualCurrentValue = assetService.calculateDepreciation(assetId);

        assertEquals(expectedCurrentValue, actualCurrentValue);

        verify(assetRepository, times(1)).findById(assetId);
    }

    @Test
    public void testGetAllAssets() {
        Asset asset1 = new Asset();
        asset1.setId(1L);
        asset1.setName("Computer");
        asset1.setPurchaseValue(new BigDecimal("1000"));

        Asset asset2 = new Asset();
        asset2.setId(2L);
        asset2.setName("Printer");
        asset2.setPurchaseValue(new BigDecimal("500"));

        List<Asset> assets = Arrays.asList(asset1, asset2);

        when(assetRepository.findAll()).thenReturn(assets);

        List<Asset> allAssets = assetService.getAllAssets();

        assertNotNull(allAssets);
        assertEquals(2, allAssets.size());

        verify(assetRepository, times(1)).findAll();
    }
}
