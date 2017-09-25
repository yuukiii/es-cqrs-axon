package app.repo.product;

import app.entity.product.ProductEntity;
import app.repo.WriteOnlyRepository;

public interface ProductWriteOnlyRepository extends WriteOnlyRepository<ProductEntity, String> {
}
