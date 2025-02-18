package com.example.jobapplication.Repository;

import com.example.jobapplication.Model.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsRepository extends JpaRepository<Jobs,Long>
{

}
