package org.haozhang.services.models.response;

import org.haozhang.services.models.Model;
import org.haozhang.services.models.request.Request;

import java.util.List;
import java.util.Optional;

public interface Response<RQ extends Request> extends Model {
    Optional<RQ> getRequest();

    List<? extends Status> getStatuses();
}
