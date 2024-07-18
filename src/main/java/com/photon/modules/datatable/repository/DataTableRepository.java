package com.photon.modules.datatable.repository;

import com.photon.modules.datatable.entity.DataTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DataTableRepository extends JpaRepository<DataTable, UUID> {
}
