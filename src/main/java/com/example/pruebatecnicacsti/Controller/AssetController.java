package com.example.pruebatecnicacsti.Controller;

import com.example.pruebatecnicacsti.Model.Asset;
import com.example.pruebatecnicacsti.Service.AssetService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetController {
    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @PostMapping
    public Asset registerAsset(@RequestBody Asset asset) {
        return assetService.registerAsset(asset);
    }

    @PutMapping("/{assetId}")
    public Asset updateAsset(@PathVariable Long assetId, @RequestBody Asset asset) {
        asset.setId(assetId);
        return assetService.updateAsset(asset);
    }

    @DeleteMapping("/{assetId}")
    public void deleteAsset(@PathVariable Long assetId) {
        assetService.deleteAsset(assetId);
    }

    @GetMapping("/{assetId}/depreciation")
    public BigDecimal calculateDepreciation(@PathVariable Long assetId) {
        return assetService.calculateDepreciation(assetId);
    }

    @GetMapping
    public List<Asset> getAllAssets() {
        return assetService.getAllAssets();
    }
}
