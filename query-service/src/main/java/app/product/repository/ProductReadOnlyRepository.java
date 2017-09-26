package app.product.repository;

import app.product.entity.ProductEntity;
import app.repo.ReadOnlyRepository;

public interface ProductReadOnlyRepository extends ReadOnlyRepository<ProductEntity, String> {
}
