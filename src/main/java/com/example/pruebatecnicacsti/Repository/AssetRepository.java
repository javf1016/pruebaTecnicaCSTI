package com.example.pruebatecnicacsti.Repository;

import com.example.pruebatecnicacsti.Model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {
    // Métodos personalizados, si es necesario
}