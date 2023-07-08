package com.example.pruebatecnicacsti.Service;

import com.example.pruebatecnicacsti.Model.Asset;
import com.example.pruebatecnicacsti.Repository.AssetRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AssetService {
    private final AssetRepository assetRepository;

    public AssetService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public Asset registerAsset(Asset asset) {
        // Lógica para registrar un nuevo activo
        return assetRepository.save(asset);
    }

    public Asset updateAsset(Asset asset) {
        // Lógica para actualizar un activo existente
        return assetRepository.save(asset);
    }

    public void deleteAsset(Long assetId) {
        // Lógica para eliminar un activo por su ID
        assetRepository.deleteById(assetId);
    }

    public BigDecimal calculateDepreciation(Long assetId) {
        // Lógica para calcular la depreciación de un activo
        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new IllegalArgumentException("Asset not found with ID: " + assetId));

        BigDecimal depreciationPercentage = asset.getDepreciationRate();
        BigDecimal depreciationAmount = asset.getPurchaseValue().multiply(depreciationPercentage);
        return  asset.getPurchaseValue().subtract(depreciationAmount);
    }

    public List<Asset> getAllAssets() {
        // Lógica para obtener todos los activos
        return assetRepository.findAll();
    }
}
