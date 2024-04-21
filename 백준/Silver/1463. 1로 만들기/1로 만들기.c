#include <stdio.h>
#include <stdlib.h>
#define MIN(a,b,c) ((a<b)?((a<c)?a:c):((b<c)?b:c))
int arr[1000001];
int main()
{
	int n;
	scanf("%d", &n);
	//arr =(int*) calloc(n + 1, (sizeof(int)*(n + 1)));
	//printf("%d %d", sizeof(*arr),sizeof(int));
	arr[2] = 1;
	arr[3] = 1;
	for (int i = 4; i <= n; i++)
	{
		int a = 999999, b=999999, c=999999;
		a = arr[i - 1] + 1;
		if (i % 2 == 0)
			b = arr[i / 2] + 1;
		if (i % 3 == 0)
			c = arr[i / 3] + 1;
		arr[i] = MIN(a, b, c);
	}
	printf("%d", arr[n]);
}
