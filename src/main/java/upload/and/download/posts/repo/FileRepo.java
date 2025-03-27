package upload.and.download.posts.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import upload.and.download.posts.entity.File;

public interface FileRepo extends JpaRepository<File, Integer> {

}
