package slubowski.jakub.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import slubowski.jakub.model.SensorData;

import java.util.Collection;

public interface DataRepository extends CrudRepository<SensorData, Integer> {

    @Query(value="SELECT * FROM SENSOR_DATA s",
            nativeQuery = true)
    public Iterable<SensorData> getFromTable();

}
