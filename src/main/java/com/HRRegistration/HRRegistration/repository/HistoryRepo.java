package com.HRRegistration.HRRegistration.repository;

import com.HRRegistration.HRRegistration.model.PreviousWorkHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepo extends JpaRepository<PreviousWorkHistory,Long> {
}
