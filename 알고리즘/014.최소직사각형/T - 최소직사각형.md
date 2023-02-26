
```java

class Solution {

	public int solution(int[][] sizes) {

	int height = 0;
	int length = 0;

	for (int i = 0; i < sizes.length; i++) {

		height = Math.max(height, Math.min(sizes[i][0], sizes[i][1]));
		length = Math.max(length, Math.max(sizes[i][0], sizes[i][1]));

	}

	return length * height;

	}
}

```