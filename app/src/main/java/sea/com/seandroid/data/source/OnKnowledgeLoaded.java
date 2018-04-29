package sea.com.seandroid.data.source;

import java.util.List;

import sea.com.seandroid.data.model.Knowledge;

public interface OnKnowledgeLoaded {

    void onFindAll(List<Knowledge> knowledgeList);
}
