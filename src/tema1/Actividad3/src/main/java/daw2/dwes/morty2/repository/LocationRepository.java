package daw2.dwes.morty2.repository;

import daw2.dwes.morty2.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}

