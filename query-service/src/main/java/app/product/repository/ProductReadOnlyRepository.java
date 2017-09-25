package app.repo.product;

import app.entity.product.ProductEntity;
import app.repo.ReadOnlyRepository;

public interface ProductReadOnlyRepository extends ReadOnlyRepository<ProductEntity, String> {
}
